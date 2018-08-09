package com.zrblog.cxf.restful.service;

import com.zrblog.cxf.restful.domain.Customer;

import javax.ws.rs.*;
import java.lang.String;

/**
 * @author zrblog
 * @version 1.0.0
 * @Description:
 * @date 2018/8/9 23:21
 */

@Path(value = "/customer")
@Produces("*/*")
public interface ICustomerService {

    @GET
    @Path(value = "/{id}/info")
    Customer findCustomerById(@PathParam("id") String id);

    @GET
    @Path(value = "/search")
    Customer findCustomerByName(@QueryParam("name") String name);

}
