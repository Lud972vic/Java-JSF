/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author LAutodidacte
 */
@Named(value = "calculController")
@SessionScoped
public class CalculController implements Serializable {

    /**
     * Creates a new instance of CalculController
     */
    private float number_1; 
    private float number_2;
    private float result;
    private String calculationType;
    private final String ADDITION = "ADDITION";
    private final String SOUSTRACTION = "SOUSTRACTION";
    private final String MULTIPLICATION = "MULTIPLICATION";
    private final String DIVISION = "DIVISION";
    private List<SelectItem> calculationList;

    public CalculController() {
        System.out.println("Je suis :: CalculController");

        number_1 = 3;
        number_2 = 8;
        result = 0;
        calculationList = null;

        /*On initialize la liste de valeurs pour le composant JSF SelectOneMenu.
        Le mettre plutot dans un post-constructeur avec l'annotation @PostConstruct*/
        //populateCalculationList();
    }

    @PostConstruct
    public void afterConstruc() {
        System.out.println("CalculController :: POST-Constructeur");
        populateCalculationList();
    }

    public void populateCalculationList() {
        /*setCalculationList((List<SelectItem>) new ArrayList());
        getCalculationList().add(new SelectItem(ADDITION));
        getCalculationList().add(new SelectItem(SOUSTRACTION));
        getCalculationList().add(new SelectItem(MULTIPLICATION));
        getCalculationList().add(new SelectItem(DIVISION));*/

        calculationList = new ArrayList();
        calculationList.add(new SelectItem(ADDITION));
        calculationList.add(new SelectItem(SOUSTRACTION));
        calculationList.add(new SelectItem(MULTIPLICATION));
        calculationList.add(new SelectItem(DIVISION));

    }

    public float getNumber_1() {
        return number_1;
    }

    public void setNumber_1(float number_1) {
        this.number_1 = number_1;
    }

    public float getNumber_2() {
        return number_2;
    }

    public void setNumber_2(float number_2) {
        this.number_2 = number_2;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public List<SelectItem> getCalculationList() {
        return calculationList;
    }

    public void setCalculationList(List<SelectItem> calculationList) {
        this.calculationList = calculationList;
    }

    public void performCalculation() {
        switch (getCalculationType()) {
            case ADDITION:
                setResult(number_1 + number_2);
                break;
            case SOUSTRACTION:
                setResult(number_1 - number_2);
                break;
            case MULTIPLICATION:
                setResult(number_1 * number_2);
                break;
            case DIVISION:
                try {
                setResult(number_1 / number_2);
            } catch (Exception ex) {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La division par 0 est interdit !", "La division par 0 est interdit !");
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            }
            break;

            default:
                break;
        }
    }

}
