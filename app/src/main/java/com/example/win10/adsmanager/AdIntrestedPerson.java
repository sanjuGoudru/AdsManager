package com.example.win10.adsmanager;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by win10 on 11-02-2020.
 */

public class AdIntrestedPerson implements Serializable{
    private int sessionID;
    private boolean isSessionIDSet;
    private int bussinessType;
    private int[] locations;
    private String website;
    private int gender;
    private int minAge;
    private int maxAge;
    private int[] strategiesTried;
    private int triedReferalCampaign;
    private int avgConversionRate;
    private int[] intrestedPlatforms;
    private int trialBudget;

    public AdIntrestedPerson(int bussinessType, int[] locations,
                             String website, int gender, int minAge,
                             int maxAge, int[] strategiesTried,
                             int triedReferalCampaign, int avgConversionRate,
                             int[] intrestedPlatforms, int trialBudget) {
        this.isSessionIDSet=false;
        this.bussinessType = bussinessType;
        this.locations = locations;
        this.website = website;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.strategiesTried = strategiesTried;
        this.triedReferalCampaign = triedReferalCampaign;
        this.avgConversionRate = avgConversionRate;
        this.intrestedPlatforms = intrestedPlatforms;
        this.trialBudget = trialBudget;
    }

    public AdIntrestedPerson() {
        this.isSessionIDSet=false;
    }

    public AdIntrestedPerson(int sessionID, int bussinessType,
                             int[] locations, String website,
                             int gender, int minAge, int maxAge, int[] strategiesTried,
                             int triedReferalCampaign, int avgConversionRate,
                             int[] intrestedPlatforms, int trialBudget) {
        this.isSessionIDSet=true;
        this.sessionID = sessionID;
        this.bussinessType = bussinessType;
        this.locations = locations;
        this.website = website;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.strategiesTried = strategiesTried;
        this.triedReferalCampaign = triedReferalCampaign;
        this.avgConversionRate = avgConversionRate;
        this.intrestedPlatforms = intrestedPlatforms;
        this.trialBudget = trialBudget;
    }

    public void setStage1(int sessionID,int bussinessType,int[] locations,String website) {
        this.sessionID = sessionID;
        this.isSessionIDSet = true;
        this.bussinessType = bussinessType;
        this.locations = locations;
        this.website = website;
    }

    public void setStage2(int gender,int minAge,int maxAge
            ,int[] strategiesTried,int triedReferalCampaign) {
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.strategiesTried = strategiesTried;
        this.triedReferalCampaign = triedReferalCampaign;
        this.avgConversionRate = avgConversionRate;
    }

    public void setStage3(int[] intrestedPlatforms,int trialBudget) {
        this.intrestedPlatforms = intrestedPlatforms;
        this.trialBudget = trialBudget;
    }

}
