package BNN

import chisel3._
import chisel3.util._

class PE extends Module{
    val io = IO(new Bundle{
        val weight = Input(SInt(1.W))
        val feature = Input(SInt(4.W)) 
        val fact = Output(SInt(4.W))
    })
    
}