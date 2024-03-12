package com.patil.sanket.groceryBookingApiProject.common;

import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static final String USER_NAME = "username";
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_USER = "user";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String STATUS = "status";

    public static final String GET_OPERATION = "Get";
    public static final String ADD_OPERATION = "Add";
    public static final String UPDATE_OPERATION = "Update";
    public static final String BOOK_OPERATION = "Book";
    public static final String DELETE_OPERATION = "DELETE";
    public static final String ACCESS_DENIED_MESSAGE = "Access Denied, %s is not authorized to perform %s operation";

    public static final Set<String> ADMIN_ALLOWED_OPERATION_SET = new HashSet<String>() {{
        add("POST");
        add("PUT");
        add("DELETE");
        add("GET");
    }} ;
}
