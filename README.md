# Scala-ofx, a micro library that helps you connect to bank accounts via OFX (Quicken's data exchange format).

## WTF Is OFX?
It's a little known fact but many (most) banks and financial institutions have severs running around that know how to spit out financial transactions in Quicken's data exchange format, OFX (Open Financial Exchange) format.

It's even less of a known fact that you can talk to these servers directly (in most cases free of charge). Hence - your bank probably has an API you can use for free and you didn't even know it.

Fair warning: Despite Quicken and many other competitors using OFX behind the scenes to "link" your accounts, it's an old spec that wasn't really built with security as a top priority...so keep that in mind.

## How Do I Use It?
For an example that connects to a Vanguard account and prints that account's balance run: 

```bash
 ./run.sh <vanguard-account-number> <vanguard-username> <vanguard-password>
```
See Driver.scala for the relevant code to accomplish this.

## Adding More Banks And Financial Institutions

If you want to add more banks/financial institutions simply write a class that extends either `InvestmentInstitution`, `CreditCardInstitution` or for a new type of Institution (ex checking/savings) write a new class that extends `com.ofx.institutions.Institution`. 

In that class you must provide the relevant information such as the OFX server's URL. There is a ton of information available at [GNUCash's Wiki page](https://wiki.gnucash.org/wiki/OFX_Direct_Connect_Bank_Settings)

## Security
Quicken, their competitors and open source programs like GNUCash have long used OFX to connect directly to banks and pull financial transactions down to the user's local computer.  

However in terms of security OFX is pretty much a joke, as like screen scraping it requires sending a user's actual username and password credentials. Ideally you'd have a read only token instead, but unfortunately that's not how OFX was designed. 

Banks seem to be slowly wisening up to this and a few have started EOL-ing their ancient OFX servers in favor of more modern (and slightly more secure APIS) but a huge amount of them still accept OFX connections and probably will continue to do so for years to come (at the time of writing it's 2017).
