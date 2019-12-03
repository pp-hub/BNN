package BNN

import chisel3._
import chisel3.util._

class AdderTreeGen{
   val io = IO(new Bundle{
    val datain = Input(Vec(128,UInt(4.W)))
	val dataout = Output(SInt(11.W))
	val valid = Input(Bool())
   })
   
   // initialize the adder
   val adder4 =  VecInit(Seq.fill(64)(Module(new SIntFourMFour).io))
   val adder5 =  VecInit(Seq.fill(32)(Module(new SIntFiveMFive).io))
   val adder6 =  VecInit(Seq.fill(16)(Module(new SIntSixMSix).io))
   val adder7 =  VecInit(Seq.fill(8)(Module(new SIntSevenMSeven).io))
   val adder8 =  VecInit(Seq.fill(4)(Module(new SIntEightMEight).io))
   val adder9 =  VecInit(Seq.fill(2)(Module(new SIntNineMNine).io))
   val adder10 =  VecInit(Seq.fill(1)(Module(new SIntTenMTen).io))
   
   val 
  for(i<-0 to 63)
  {
    adder4(i).io.A := io.datain(2*i).asSInt
	addrt4(i).io.B := io.datain(2*1+1).asSInt
	adder4(i).io.CE := 
  }
  for(i<-0 to 31)
  {
    adder5(i).io.A := adder4(2*i).io.S
	adder5(i).io.B := adder4(2*i+1).io.S
	adder5(i).io.CE := adder4(2*i).io.
  }
  for(i<-0 to 15)
  {
    adder6(i).io.A := adder5(2*i).io.S
	adder6(i).io.B := adder5(2*i+1).io.S
	adder6(i).io.CE := adder5(2*i).io.
  }
  for(i<-0 to 7)
  {
    adder7(i).io.A := adder6(2*i).io.S
	adder7(i).io.B := adder6(2*i+1).io.S
	adder7(i).io.CE := adder6(2*i).io.
  }
  for(i<-0 to 3)
  {
    adder8(i).io.A := adder7(2*i).io.S
	adder8(i).io.B := adder7(2*i+1).io.S
	adder8(i).io.CE := adder7(2*i).io.
  }
  for(i<-0 to 1)
  {
    adder9(i).io.A := adder4(2*i).io.S
	adder9(i).io.B := adder4(2*i+1).io.S
	adder9(i).io.CE := adder4(2*i).io.
  }
}
