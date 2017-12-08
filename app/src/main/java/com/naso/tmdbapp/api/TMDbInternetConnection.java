package com.naso.tmdbapp.api;



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
