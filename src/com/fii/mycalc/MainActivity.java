package com.fii.mycalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private double calcResult = 0.0;
    private String input = "0";
    char lastOp = ' ';
    boolean newNr = false;
    boolean firstCalc = true;

    /**
     * @return the calcResult
     */
    public double getCalcResult() {
	return calcResult;
    }

    /**
     * @param calcResult
     *            the calcResult to set
     */
    public void setCalcResult(double calcResult) {
	this.calcResult = calcResult;
    }

    /**
     * @return the input
     */
    public String getInput() {
	return input;
    }

    /**
     * @param input
     *            the input to set
     */
    public void setInput(String input) {
	this.input = input;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    private void setResToView() {
	TextView tv = (TextView) this.findViewById(R.id.inputTextView);
	if (calcResult % 1 > 0) {
	    tv.setText(Double.toString(calcResult));
	} else {
	    tv.setText(Integer.toString((int) calcResult));
	}
    }

    private void setInputToView() {
	TextView tv = (TextView) this.findViewById(R.id.inputTextView);
	tv.setText(input);
    }

    private void addNumToInput(int val) {
	if (input.equals("0") || newNr) {
	    input = Integer.toString(val);
	    newNr = false;
	} else {
	    input += val;
	}
    }

    private void doLastOp(double currentNr) {
	newNr = true;
	switch (lastOp) {
	case '-':
	    calcResult -= currentNr;
	    break;
	case '+':
	    calcResult += currentNr;
	    break;
	case '*':
	    calcResult *= currentNr;
	    break;
	case '/':
	    calcResult /= currentNr;
	    break;
	default:
	    calcResult = currentNr;
	    break;
	}
    }

    private void doMath(char operator) {
	double currentNr = Double.parseDouble(input);
	doLastOp(currentNr);
	lastOp = operator;
    }

    public void clickedNum0(View view) {
	addNumToInput(0);
	setInputToView();
    }

    public void clickedNum1(View view) {
	addNumToInput(1);
	setInputToView();
    }

    public void clickedNum2(View view) {
	addNumToInput(2);
	setInputToView();
    }

    public void clickedNum3(View view) {
	addNumToInput(3);
	setInputToView();
    }

    public void clickedNum4(View view) {
	addNumToInput(4);
	setInputToView();
    }

    public void clickedNum5(View view) {
	addNumToInput(5);
	setInputToView();
    }

    public void clickedNum6(View view) {
	addNumToInput(6);
	setInputToView();
    }

    public void clickedNum7(View view) {
	addNumToInput(7);
	setInputToView();
    }

    public void clickedNum8(View view) {
	addNumToInput(8);
	setInputToView();
    }

    public void clickedNum9(View view) {
	addNumToInput(9);
	setInputToView();
    }

    public void clickedNumMin(View view) {
	doMath('-');
    }

    public void clickedNumPlus(View view) {
	doMath('+');
    }

    public void clickedNumDiv(View view) {
	doMath('/');
    }

    public void clickedNumMul(View view) {
	doMath('*');
    }

    public void clickedNumDot(View view) {
	if (!input.contains(".")) {
	    input += ".";
	}
    }

    public void clickedNumEq(View view) {
	doLastOp(Double.parseDouble(input));
	setResToView();
	calcResult = 0.0;
	newNr = true;
	input = "0";
    }

    public void clickedNumClear(View view) {
	input = "0";
	calcResult = 0.0;
	setInputToView();
    }

    public void clickedNumDel(View view) {
	if (input.length() > 0) {
	    input = input.substring(0, input.length() - 1);
	    setResToView();
	}
    }
}
