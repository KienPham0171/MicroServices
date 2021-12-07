package com.example.organizationservice.utils;

public class UserContextHolder {
    private static final ThreadLocal<UserContext> data = new ThreadLocal<>();

    public static UserContext getUserContext()
    {
        UserContext userContext = data.get();
        if(userContext == null)
        {
            userContext = createEmptyUserContext();
            setUserContext(userContext);
        }
        return data.get();
    }

    private static void setUserContext(UserContext userContext){
        data.set(userContext);
    }
    private static UserContext createEmptyUserContext() {
        return new UserContext();
    }
}
