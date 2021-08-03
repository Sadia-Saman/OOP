public class Request {
    private String service;
    private Organization provider;
    private String seeker;

    public Request(String service,String seeker, Organization provider) {
        this.service = service;
        this.seeker=seeker;
        this.provider = provider;
    }

    public String getService() {
        return service;
    }

    public String getSeeker() {
        return seeker;
    }

    public Organization getProvider() {
        return provider;
    }
}
