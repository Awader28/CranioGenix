package org.craniogenix.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "patients")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Prevents null values from appearing

public class PatientRecord {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(double bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public double getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(double bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public double getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(double glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public double getCholesterolLevel() {
        return cholesterolLevel;
    }

    public void setCholesterolLevel(double cholesterolLevel) {
        this.cholesterolLevel = cholesterolLevel;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public String getAlcoholConsumption() {
        return alcoholConsumption;
    }

    public void setAlcoholConsumption(String alcoholConsumption) {
        this.alcoholConsumption = alcoholConsumption;
    }

    public String getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(String physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public List<String> getComorbidities() {
        return comorbidities;
    }

    public void setComorbidities(List<String> comorbidities) {
        this.comorbidities = comorbidities;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getMedicationHistory() {
        return medicationHistory;
    }

    public void setMedicationHistory(String medicationHistory) {
        this.medicationHistory = medicationHistory;
    }

    public boolean isHasTumor() {
        return hasTumor;
    }

    public void setHasTumor(boolean hasTumor) {
        this.hasTumor = hasTumor;
    }

    @Id
    private String id; // Change from ObjectId to String
    private String name;
    private int age;
    private String gender;
    private double height; // in cm
    private double weight; // in kg
    private double bmi; // Body Mass Index
    private double bloodPressureSystolic; // Systolic BP (e.g., 120)
    private double bloodPressureDiastolic; // Diastolic BP (e.g., 80)
    private double glucoseLevel; // mg/dL
    private double cholesterolLevel; // mg/dL
    private String smokingStatus; // Smoker, Non-smoker, Former Smoker
    private String alcoholConsumption; // None, Moderate, Heavy
    private String physicalActivity; // Sedentary, Active, Very Active
    private List<String> comorbidities; // e.g., ["Diabetes", "Hypertension"]
    private String familyHistory; // e.g., "Father had brain tumor"
    private String medicationHistory; // e.g., "Metformin, Aspirin"
    private boolean hasTumor; // Prediction from Python model

    @Override
    public String toString() {
        return "PatientRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                ", bloodPressureSystolic=" + bloodPressureSystolic +
                ", bloodPressureDiastolic=" + bloodPressureDiastolic +
                ", glucoseLevel=" + glucoseLevel +
                ", cholesterolLevel=" + cholesterolLevel +
                ", smokingStatus='" + smokingStatus + '\'' +
                ", alcoholConsumption='" + alcoholConsumption + '\'' +
                ", physicalActivity='" + physicalActivity + '\'' +
                ", comorbidities=" + comorbidities +
                ", familyHistory='" + familyHistory + '\'' +
                ", medicationHistory='" + medicationHistory + '\'' +
                ", hasTumor=" + hasTumor +
                '}';
    }
}
