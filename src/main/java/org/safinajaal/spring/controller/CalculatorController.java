// Need to add integer check

package org.safinajaal.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tools")
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "firstInt", required = false) int firstInt,
                            @RequestParam(value = "secondInt", required = false) int secondInt,
                            @RequestParam(value = "actionType", required = false) String actionType,
                            Model model){
        double result;

        switch(actionType){
            case "addition":
                result = firstInt + secondInt;
                break;
            case "subtraction":
                result = firstInt - secondInt;
                break;
            case "multiplication":
                result = firstInt * secondInt;
                break;
            case "division":
                result = firstInt / (double)secondInt;
                break;
            default:
                model.addAttribute("failedCalculationMessage", "You entered invalid actionType. " +
                    "Try again with one of the actionType: addition, subtraction, multiplication, division. Your calculated value has been set to default 0.0");
                result = 0;
        }
        
        model.addAttribute("resultMessage", result);
        return "tools/calculator.html";
    }

    @GetMapping("/calculator-starter-page")
    public String calculatorStarterPage(){
        return "tools/calculator-starter-page.html";
    }
}
