package com.ofx.institutions.impl

import com.ofx.institutions.InvestmentInstitution

case object Vanguard extends InvestmentInstitution {
  override val financialInstitutionId = ""
  override val brokerId = "vanguard.com"
  override val ofxURL = "https://vesnc.vanguard.com/us/OfxDirectConnectServlet"
  override val organization = "Vanguard"
}