package calculator.model

class Multiply(calc: Calculator) extends CalculatorState(calc: Calculator){
  calc.flush()
  calc.RHS = 1
  override def numberPressed(): Unit = {
    calc.numbers = (calc.numbers*10.0) + calc.currentNum
    calc.RHS = calc.numbers
  }
  override def EqualPress(): Unit = {
    calc.numbers = calc.LHS * calc.RHS
    calc.LHS = calc.numbers
    calc.nWipe()
    calc.state = new EqualFromMultiply(calc)
  }
  override def DecimalPress(): Unit = {
    calc.state = new DecimalFromMultiply(calc)
  }
  override def AddPress(): Unit = {
   calc.MulIt()
    //calc.numbers = calc.LHS * calc.RHS
    calc.state = new Add(calc)
  }
  override def SubtractPress(): Unit = {
    calc.MulIt()
    //calc.numbers = calc.LHS * calc.RHS
    calc.state = new Subtract(calc)
  }
  override def MultiplyPress(): Unit = {
    calc.LHS = calc.LHS * calc.RHS
    calc.numbers = 0
  }
  override def DividePress(): Unit = {
    calc.MulIt()
    //calc.numbers = calc.LHS * calc.RHS
    calc.state = new Divide(calc)
  }
}

