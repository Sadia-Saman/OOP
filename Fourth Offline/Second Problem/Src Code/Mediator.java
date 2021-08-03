public interface Mediator {
    void passRequest(String service,String seeker);
    void Notify(String service);
    Organization getOrg(String name);
}
