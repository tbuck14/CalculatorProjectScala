package calculator.model

class EqualFromAdd(calc: Calculator) extends CalculatorState(calc: Calculator){
  override def numberPressed(): Unit = {
    calc.numbers = 0
    calc.numbers = (calc.numbers*10.0) + calc.currentNum
    calc.LHS = calc.numbers
    calc.state = new Start(calc)
  }
  override def EqualPress(): Unit = {
    calc.numbers = calc.LHS + calc.RHS
    calc.LHS = calc.numbers
  }
  override def DecimalPress(): Unit = {
    calc.numbers = 0
    calc.numbers += calc.currentNum*Math.pow(10.0, -calc.n)
    calc.n += 1.0
    val n: Double = calc.numbers
    calc.LHS = n
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
