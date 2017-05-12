package com.ofx.institutions

import scala.collection.JavaConverters._

import com.webcohesion.ofx4j.client.{ FinancialInstitutionAccount, InvestmentAccount }
import com.webcohesion.ofx4j.client.CreditCardAccount

object AccountQueries {
  implicit val investments = InvestmentAccountQueries
  implicit val cc = CreditCardAccountQueries

  implicit class AccountQueriesImpl[T <: FinancialInstitutionAccount](account: T)(implicit ev: AccountQueries[T]) {
    def currentBalance: Double = {
      ev.currentBalance(account)
    }
  }
}

trait AccountQueries[T <: FinancialInstitutionAccount] {
  def currentBalance(account: T): Double
}

object InvestmentAccountQueries extends AccountQueries[InvestmentAccount] {
  override def currentBalance(account: InvestmentAccount): Double = {
    val today = new java.util.Date()
    val statement = account.readStatement(today, today)
    statement.getPositionList.getPositions.asScala.map { _.getMarketValue.toDouble }.sum
  }
}

object CreditCardAccountQueries extends AccountQueries[CreditCardAccount] {
  override def currentBalance(account: CreditCardAccount): Double = {
    val today = new java.util.Date()
    val statement = account.readStatement(today, today)
    statement.getAvailableBalance.getAmount
  }
}