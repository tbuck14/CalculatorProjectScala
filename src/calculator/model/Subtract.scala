package calculator.model

  class Subtract(calc: Calculator) extends CalculatorState(calc: Calculator){
    calc.flush()
    calc.RHS = 0
  override def numberPressed(): Unit = {
    calc.numbers = (calc.numbers*10.0) + calc.currentNum
    calc.RHS = calc.numbers
  }
  override def EqualPress(): Unit = {
    calc.numbers = calc.LHS - calc.RHS
    calc.LHS = calc.numbers
    calc.nWipe()
    calc.state = new EqualFromSubtract(calc)
  }
  override def DecimalPress(): Unit = {
    calc.state = new DecimalFromSubtract(calc)
  }
  override def AddPress(): Unit = {
    calc.SubIt()
    calc.state = new Add(calc)
  }
  override def SubtractPress(): Unit = {
    calc.LHS = calc.LHS - calc.RHS
    calc.numbers = 0
  }
  override def MultiplyPress(): Unit = {
    calc.SubIt()
    calc.state = new Multiply(calc)
  }
  override def DividePress(): Unit = {
    calc.SubIt()
    calc.state = new Divide(calc)
  }
}

