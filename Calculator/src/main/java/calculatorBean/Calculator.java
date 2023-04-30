package calculatorBean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator{
    
	private String first_num = "0";
    private String second_num = "0";
    private String mathOperator = "addition";
    private String result;
	
    public String getResult () {
        return result;
    }

    public String getMathOperator () {
        return mathOperator;
    }

    public void setMathOperator (String mathOperator) {
        this.mathOperator = mathOperator;
    }

    public void setResult (String result) {
        this.result = result;
    }

    public String getFirst_num () {
        return first_num;
    }

    public void setFirst_num (String first_num) {
        this.first_num = first_num.trim ();
    }

    public String getSecond_num () {
        return second_num;
    }

    public void setSecond_num (String second_num) {
        this.second_num = second_num.trim ();
    }

    public void calculate() {
        
		BigDecimal first = new BigDecimal (this.first_num);
        BigDecimal second = new BigDecimal (this.second_num);
        switch(this.mathOperator){
			case "addition":
				this.result = first.add(second).toString();
				break;
			case "subtraction":
				this.result = first.subtract(second).toString();
				break;
			case "multiplication":
				this.result = first.multiply(second).toString();
				break;
			case "division":
				if(second.doubleValue() == 0) {
					throw new RuntimeException ("The dividend cannot be zero");
				}
				this.result = first.divide(second, 10, RoundingMode.HALF_DOWN).toString();
				break;
			default:
				break;
        }
    }
}
