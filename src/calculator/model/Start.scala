package calculator.model

class Start(calc: Calculator) extends CalculatorState(calc: Calculator){
  override def numberPressed(): Unit = {
      calc.numbers = (calc.numbers*10.0) + calc.currentNum
    calc.LHS = calc.numbers
  }

  override def EqualPress(): Unit = {
  }
  override def DecimalPress(): Unit = {
  calc.state = new DecimalFromStart(calc)
  }
  override def AddPress(): Unit = {
    calc.state = new Add(calc)
  }
  override def SubtractPress(): Unit = {
    calc.state = new Subtract(calc)
  }
  override def MultiplyPress(): Unit = {
    calc.state = new Multiply(calc)
  }
  override def DividePress(): Unit = {
    calc.state = new Divide(calc)
  }
}
