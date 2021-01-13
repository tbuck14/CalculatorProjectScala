package calculator.model

class Add(calc: Calculator) extends CalculatorState(calc: Calculator){
  calc.flush()
  calc.RHS = 0
  override def numberPressed(): Unit = {
    calc.numbers = (calc.numbers*10.0) + calc.currentNum
    calc.RHS = calc.numbers
  }
  override def EqualPress(): Unit = {
    calc.numbers = calc.LHS + calc.RHS
    calc.LHS = calc.numbers
    calc.nWipe()
    calc.state = new EqualFromAdd(calc)
  }
  override def DecimalPress(): Unit = {
    calc.state = new DecimalFromAdd(calc)
  }
  override def AddPress(): Unit = {
    calc.LHS = calc.LHS + calc.RHS
    calc.numbers = 0
  }
  override def SubtractPress(): Unit = {
    calc.AddIt()
    calc.state = new Subtract(calc)
  }
  override def MultiplyPress(): Unit = {
    calc.AddIt()
    calc.state = new Multiply(calc)
  }
  override def DividePress(): Unit = {
    calc.AddIt()
    calc.state = new Divide(calc)
  }
}

