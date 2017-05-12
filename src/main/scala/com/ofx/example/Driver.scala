package com.ofx.example

import com.ofx.institutions.AccountQueries._
import com.ofx.institutions.impl.Vanguard

/** Connects to a Vanguard brokerage account and prints the account balance via OFX */
object Driver extends App {
  val (acct, user, pass) = args match {
    case Array(accountNumber, username, password) =>
      (accountNumber, username, password)

    case _ =>
      throw new IllegalArgumentException("args must be: <vanguard account number>, <vanguard username> <vanguard password>")
  }

  val account = Vanguard.getAccount(acct, user, pass)
  println(s"Your Account Balance: ${account.currentBalance}")
}