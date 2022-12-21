package com.haze.calculator_gui;

public class UserSettings {
    public static final String PREFERENCES = "preferences";

    public static final String custom_Theme = "customTheme";

    public static final String dark_Theme = "darkTheme";

    public static final String retro_Theme = "retroTheme";

    public static final String bling_Theme = "bling_Theme";


    private String customTheme;



    public String getCustomTheme(){
        return customTheme;
    }

    public void setCustomTheme(String customTheme){
        this.customTheme = customTheme;
    }

}
