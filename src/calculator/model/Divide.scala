package calculator.model

class Divide(calc: Calculator) extends CalculatorState(calc: Calculator){
  calc.flush()
  calc.RHS = 1
  override def numberPressed(): Unit = {
    calc.numbers = (calc.numbers*10.0) + calc.currentNum
    calc.RHS = calc.numbers
  }
  override def EqualPress(): Unit = {
    calc.numbers = calc.LHS / calc.RHS
    calc.LHS = calc.numbers
    calc.nWipe()
    calc.state = new EqualFromDivide(calc)
  }
  override def DecimalPress(): Unit = {
    calc.state = new DecimalFromDivide(calc)
  }
  override def AddPress(): Unit = {
    calc.DivIt()
    //calc.numbers = calc.LHS / calc.RHS
    calc.state = new Add(calc)
  }
  override def SubtractPress(): Unit = {
    calc.DivIt()
    //calc.numbers = calc.LHS / calc.RHS
    calc.state = new Subtract(calc)
  }
  override def MultiplyPress(): Unit = {
    calc.DivIt()
    //calc.numbers = calc.LHS / calc.RHS
    calc.state = new Multiply(calc)
  }
  override def DividePress(): Unit = {
    calc.LHS = calc.LHS / calc.RHS
    calc.numbers = 0
  }
}

