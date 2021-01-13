package calculator.model


class Calculator() {

  // Accessed by View. You should edit this method as you build functionality
  var state: CalculatorState = new Start(this)
  var numbers: Double = 0.0
  var currentNum: Double = 0.0
  var n: Double = 1.0
  var LHS: Double = 0.0
  var RHS: Double = 0.0
  var add: Double = LHS + RHS
  var sub: Double = LHS - RHS
  var mult: Double = LHS * RHS
  var div: Double = LHS / RHS
  def displayNumber(): Double = {
    numbers
  }
  def accept(n: Double): Unit ={
  currentNum = n
  }
  def numberPressed(): Unit ={
    this.state.numberPressed()
  }
  def EqualPress(): Unit = {
  this.state.EqualPress()
  }
  def ClearPress(): Unit = {
    this.state = new Start(this)
    this.numbers = 0.0
    this.currentNum = 0.0
    this.n = 1.0
    RHS = 0
    LHS = 0
  }
  def DecimalPress(): Unit = {
  this.state.DecimalPress()
  }
  def AddPress(): Unit = {
  this.state.AddPress()
  }
  def SubtractPress(): Unit = {
  this.state.SubtractPress()
  }
  def MultiplyPress(): Unit = {
  this.state.MultiplyPress()
  }
  def DividePress(): Unit = {
  this.state.DividePress()
  }
  def flush(): Unit = {
    numbers = 0.0
  }
  def nWipe(): Unit = {
    n = 1.0
  }
  def AddIt(): Unit = {
    LHS += RHS
  }
  def SubIt(): Unit = {
    LHS -= RHS
  }
  def MulIt(): Unit = {
    LHS = LHS * RHS
  }
  def DivIt(): Unit = {
    LHS = LHS/RHS
  }
}
