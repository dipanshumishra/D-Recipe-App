package com.example.login.Model;

public class CategoryTwo {

    String recipeImg , recipeName;
    String ingDescription,prepTime,cookTime,totalIngrequired,stepsRequired,Process,ingList;
    public CategoryTwo() { }

    public CategoryTwo(String recipeImg, String recipeName, String ingDescription, String prepTime, String cookTime, String totalIngrequired, String stepsRequired, String process, String ingList) {
        this.recipeImg = recipeImg;
        this.recipeName = recipeName;
        this.ingDescription = ingDescription;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.totalIngrequired = totalIngrequired;
        this.stepsRequired = stepsRequired;
        Process = process;
        this.ingList = ingList;
    }

    public String getRecipeImg() {
        return recipeImg;
    }

    public void setRecipeImg(String recipeImg) {
        this.recipeImg = recipeImg;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngDescription() {
        return ingDescription;
    }

    public void setIngDescription(String ingDescription) {
        this.ingDescription = ingDescription;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getTotalIngrequired() {
        return totalIngrequired;
    }

    public void setTotalIngrequired(String totalIngrequired) {
        this.totalIngrequired = totalIngrequired;
    }

    public String getStepsRequired() {
        return stepsRequired;
    }

    public void setStepsRequired(String stepsRequired) {
        this.stepsRequired = stepsRequired;
    }

    public String getProcess() {
        return Process;
    }

    public void setProcess(String process) {
        Process = process;
    }

    public String getIngList() {
        return ingList;
    }

    public void setIngList(String ingList) {
        this.ingList = ingList;
    }
}

