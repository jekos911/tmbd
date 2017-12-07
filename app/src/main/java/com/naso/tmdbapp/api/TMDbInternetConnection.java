package com.naso.tmdbapp.api;

/**
 * Created by жекос on 02.12.2017.
 */

public class TMDbInternetConnection {
    private static TMDbInternetConnection interfaceForApi;

    private TMDbInterface tmDbInterface;

    private TMDbInternetConnection()
    {
        tmDbInterface = MyServiceGenerator.createService(TMDbInterface.class);
    }

    public static TMDbInternetConnection getInterfaceForApi() {
        if (interfaceForApi == null)
            interfaceForApi = new TMDbInternetConnection();
        return interfaceForApi;
    }

    public TMDbInterface makeGetRequest() {
        return tmDbInterface;
    }

}
