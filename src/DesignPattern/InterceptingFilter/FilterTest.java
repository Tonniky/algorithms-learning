package DesignPattern.InterceptingFilter;


public class FilterTest {
    public static void main(String[] args) {
        FilterManager fileManager = new FilterManager(new Target());
        fileManager.setFilterChain(new AuthenticationFilter());
        fileManager.setFilterChain(new DebugFilter());

        client lient = new client();
        lient.setFilterManager(fileManager);
        lient.sendRequest("HOME");
    }
}
