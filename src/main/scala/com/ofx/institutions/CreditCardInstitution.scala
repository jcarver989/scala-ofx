package com.ofx.institutions

import com.webcohesion.ofx4j.client.InvestmentAccount
import com.webcohesion.ofx4j.domain.data.investment.accounts.InvestmentAccountDetails
import com.webcohesion.ofx4j.client.CreditCardAccount
import com.webcohesion.ofx4j.domain.data.creditcard.CreditCardAccountDetails

trait CreditCardInstitution extends Institution[CreditCardAccount] {
  override def getAccount(accountNumber: String, username: String, password: String): CreditCardAccount = {
    val details = new CreditCardAccountDetails()
    details.setAccountNumber(accountNumber)
    client.loadCreditCardAccount(details, username, password)
  }
}