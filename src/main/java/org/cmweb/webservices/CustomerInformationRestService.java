package org.cmweb.webservices;
/*
@author cagatay.gokcel
 */

import org.apache.log4j.Logger;
import org.cmweb.constants.RestServiceConstants;
import org.cmweb.data.CustomerData;
import org.cmweb.services.ILoginService;
import org.cmweb.util.StringUtil;
import org.cmweb.webservices.model.LoginRequest;
import org.cmweb.webservices.model.LoginResponse;
import org.cmweb.webservices.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/rest")
public class CustomerInformationRestService {

    protected static final Logger LOG = Logger.getLogger(CustomerInformationRestService.class);

    @Autowired
    ILoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/xml", "application/json"})
    public
    @ResponseBody
    LoginResponse loginCustomer(@RequestBody LoginRequest loginRequest) {
        LOG.debug("loginCustomer service started");
        LoginResponse loginResponse = new LoginResponse();
        ResponseResult responseResult = validateRequest(loginRequest);

        if(RestServiceConstants.SUCCESS_CODE ==  responseResult.getResultCode()) {

            LOG.debug("loginCustomer service validation success");

            CustomerData customerData = loginService.login(loginRequest.getUsername(), loginRequest.getPassword());
            if(customerData == null) {
                LOG.debug("loginService authentication failed");
                responseResult.setResultCode(RestServiceConstants.AUTHENTICATION_FAILED_CODE);
                responseResult.setResultDesc(RestServiceConstants.AUTHENTICATION_FAILED);
                loginResponse.setResponseResult(responseResult);
            } else {
                LOG.debug("loginService authentication success");
                // login is successfully

                // set response result success
                responseResult.setResultCode(RestServiceConstants.SUCCESS_CODE);
                responseResult.setResultDesc(RestServiceConstants.SUCCESS_RESULT);
                loginResponse.setResponseResult(responseResult);
                loginResponse.setCustomerData(customerData);
            }

        } else {
            LOG.debug("loginCustomer service validation failed");
            loginResponse.setResponseResult(responseResult);
        }

        return loginResponse;
    }

    private ResponseResult validateRequest(LoginRequest loginRequest) {
        ResponseResult result = new ResponseResult();
        if(loginRequest == null) {
            result.setResultCode(RestServiceConstants.GENERAL_ERR_CODE);
            result.setResultDesc("Request is empty");
        }
        if(StringUtil.isEmpty(loginRequest.getUsername()) && StringUtil.isEmpty(loginRequest.getPassword())) {
            result.setResultDesc("Username and Password are empty");
            result.setResultCode(RestServiceConstants.LOGIN_INFORMATIONS_MUST_BE_FILLED);
        } else if(StringUtil.isEmpty(loginRequest.getUsername())) {
            result.setResultDesc("Username is empty");
            result.setResultCode(RestServiceConstants.USERNAME_EMPTY);
        }
        else if(StringUtil.isEmpty(loginRequest.getUsername())) {
            result.setResultDesc("Password is empty");
            result.setResultCode(RestServiceConstants.PASSWORD_EMPTY);
        }

        return result;
    }


}
