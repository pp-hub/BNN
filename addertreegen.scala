package BNN

import chisel3._
import chisel3.util._

class AdderTreeGen extends Module{
   val io = IO(new Bundle{
    val datain = Input(Vec(128,UInt(4.W)))
	  val dataout = Output(SInt(11.W))
	  val valid = Input(Bool())
   })
   
   // initialize the adder
   val adder4 =  VecInit(Seq.fill(64)(Module(new SIntFourAFour).io))
   val adder5 =  VecInit(Seq.fill(32)(Module(new SIntFiveAFive).io))
   val adder6 =  VecInit(Seq.fill(16)(Module(new SIntSixASix).io))
   val adder7 =  VecInit(Seq.fill(8)(Module(new SIntSevenASeven).io))
   val adder8 =  VecInit(Seq.fill(4)(Module(new SIntEightAEight).io))
   val adder9 =  VecInit(Seq.fill(2)(Module(new SIntNineANine).io))
   val adder10 =  Module(new SIntTenATen)
   
   val valid = RegInit(VecInit(Seq.fill(6)(false.B)))
   valid(0) := io.valid
   for(i<-0 to 4)
   {
     valid(i+1) := valid(i)
   }
   
  for(i<-0 to 63)
  {
  adder4(i).A := io.datain(2*i).asSInt
	adder4(i).B := io.datain(2*1+1).asSInt
	adder4(i).CE := io.valid
	adder4(i).CLK := clock
  }
  for(i<-0 to 31)
  {
  adder5(i).A := adder4(2*i).S
	adder5(i).B := adder4(2*i+1).S
	adder5(i).CE := valid(0)
	adder5(i).CLK := clock
  }
  for(i<-0 to 15)
  {
    adder6(i).A := adder5(2*i).S
	adder6(i).B := adder5(2*i+1).S
	adder6(i).CE := valid(1)
	adder6(i).CLK := clock
  }
  for(i<-0 to 7)
  {
    adder7(i).A := adder6(2*i).S
	adder7(i).B := adder6(2*i+1).S
	adder7(i).CE := valid(2)
	adder7(i).CLK := clock
  }
  for(i<-0 to 3)
  {
    adder8(i).A := adder7(2*i).S
	adder8(i).B := adder7(2*i+1).S
	adder8(i).CE := valid(3)
	adder8(i).CLK := clock
  }
  for(i<-0 to 1)
  {
    adder9(i).A := adder8(2*i).S
	adder9(i).B := adder8(2*i+1).S
	adder9(i).CE := valid(4)
	adder9(i).CLK := clock
  }
  adder10.io.A := adder9(0).S
  adder10.io.B := adder9(1).S
  adder10.io.CE := valid(5)
  adder10.io.CLK := clock
  io.dataout := adder10.io.S
}
