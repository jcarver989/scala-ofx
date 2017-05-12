package com.ofx.institutions

import java.net.URL

import com.webcohesion.ofx4j.client.FinancialInstitutionAccount
import com.webcohesion.ofx4j.client.impl.{ BaseFinancialInstitutionData, FinancialInstitutionServiceImpl }

/** Represents an Financial Institution  - ex Bank of America, Vanguard, Chase etc. */
trait Institution[T <: FinancialInstitutionAccount] {
  val financialInstitutionId: String
  val ofxURL: String
  val organization: String

  private val service = new FinancialInstitutionServiceImpl()

  protected lazy val institutionData = {
    val data = new BaseFinancialInstitutionData
    data.setFinancialInstitutionId(financialInstitutionId)
    data.setOFXURL(new URL(ofxURL))
    data.setOrganization(organization)
    data
  }

  protected lazy val client = service.getFinancialInstitution(institutionData)

  def getAccount(accountNumber: String, username: String, password: String): T
}