package com.ofx.institutions.impl

import com.ofx.institutions.CreditCardInstitution

case object Chase extends CreditCardInstitution {
  override val financialInstitutionId = "10898"
  override val ofxURL = "https://ofx.chase.com"
  override val organization = "B1"
}