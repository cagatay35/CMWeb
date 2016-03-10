package org.cmweb.webservices;
/*
@author cagatay.gokcel
 */

import org.apache.log4j.Logger;
import org.cmweb.constants.RestServiceConstants;
import org.cmweb.data.CustomerData;
import org.cmweb.exceptions.CMException;
import org.cmweb.facades.customer.ICustomerFacade;
import org.cmweb.services.login.ILoginService;
import org.cmweb.services.security.ITokenAuthService;
import org.cmweb.util.StringUtil;
import org.cmweb.webservices.model.LoginRequest;
import org.cmweb.webservices.model.LoginResponse;
import org.cmweb.webservices.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/rest/customer")
public class CustomerInformationRestService {

    protected static final Logger LOG = Logger.getLogger(CustomerInformationRestService.class);

    @Autowired
    ILoginService loginService;

    @Autowired
    ICustomerFacade customerFacade;

    @Autowired
    ITokenAuthService tokenAuthService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/xml", "application/json"})
    public
    @ResponseBody
    LoginResponse loginCustomer(@RequestBody LoginRequest loginRequest) {
        LOG.debug("loginCustomer service started");
        LoginResponse loginResponse = new LoginResponse();
        ResponseResult responseResult = validateRequest(loginRequest);

        if (RestServiceConstants.SUCCESS_CODE == responseResult.getResultCode()) {

            LOG.debug("loginCustomer service validation success");

            CustomerData customerData = loginService.login(loginRequest.getUsername(), loginRequest.getPassword());
            if (customerData == null) {
                LOG.debug("loginService authentication failed");
                responseResult.setResultCode(RestServiceConstants.AUTHENTICATION_FAILED_CODE);
                responseResult.setResultDesc(RestServiceConstants.AUTHENTICATION_FAILED);
                loginResponse.setResponseResult(responseResult);
                loginResponse.setToken(null);
            } else {
                LOG.debug("loginService authentication success");
                // login is successfully
                // set response result success
                responseResult.setResultCode(RestServiceConstants.SUCCESS_CODE);
                responseResult.setResultDesc(RestServiceConstants.SUCCESS_RESULT);
                loginResponse.setResponseResult(responseResult);
                loginResponse.setCustomerData(customerData);
                loginResponse.setToken(tokenAuthService.createToken(customerData.getId()));
            }

        } else {
            LOG.debug("loginCustomer service validation failed");
            loginResponse.setResponseResult(responseResult);
        }
        return loginResponse;
    }


    @RequestMapping(value = "/getById/{customerId}", method = RequestMethod.GET, produces = {"application/json"})
    public
    @ResponseBody
    ResponseEntity<CustomerData> getAllCustomers(@PathVariable(value = "customerId") String customerId) {
        if (StringUtil.isEmpty(customerId)) {
            return new ResponseEntity<CustomerData>(HttpStatus.NO_CONTENT);
        } else {
            try {
                CustomerData customerData = customerFacade.getCustomerById(Integer.valueOf(customerId));
                return new ResponseEntity<CustomerData>(customerData,HttpStatus.OK);
            } catch (CMException e) {
                return new ResponseEntity<CustomerData>(HttpStatus.NO_CONTENT);
            }


        }

    }


    private ResponseResult validateRequest(LoginRequest loginRequest) {
        ResponseResult result = new ResponseResult();
        if (loginRequest == null) {
            result.setResultCode(RestServiceConstants.GENERAL_ERR_CODE);
            result.setResultDesc("Request is empty");
        }
        if (StringUtil.isEmpty(loginRequest.getUsername()) && StringUtil.isEmpty(loginRequest.getPassword())) {
            result.setResultDesc("Username and Password are empty");
            result.setResultCode(RestServiceConstants.LOGIN_INFORMATIONS_MUST_BE_FILLED);
        } else if (StringUtil.isEmpty(loginRequest.getUsername())) {
            result.setResultDesc("Username is empty");
            result.setResultCode(RestServiceConstants.USERNAME_EMPTY);
        } else if (StringUtil.isEmpty(loginRequest.getUsername())) {
            result.setResultDesc("Password is empty");
            result.setResultCode(RestServiceConstants.PASSWORD_EMPTY);
        }

        return result;
    }


}
