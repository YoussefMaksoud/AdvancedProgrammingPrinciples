package com.ExE2Lab3;


public class FrontEnd {
    private RegistrationApp app;

    public void setApp(RegistrationApp app) {
        this.app = app;
    }

    public RegistrationApp getApp() {
        return app;
    }

    public FrontEnd(){
        app = new RegistrationApp();
    }
    public static void main(String args[]){
        FrontEnd f = new FrontEnd();
        f.app.createSchool();
        f.app.createOfferings(f.getApp().getCat());
        f.app.menu(f.getApp().getCat());

    }
}
