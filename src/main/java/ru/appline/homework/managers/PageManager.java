package ru.appline.homework.managers;

import ru.appline.homework.pages.MortgagePage;
import ru.appline.homework.pages.StartPage;

public class PageManager {

     private static PageManager pageManager;

     private static StartPage startPage;

     private static MortgagePage mortgagePage;


    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public MortgagePage getMortgagePage() {
        if (mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }

}