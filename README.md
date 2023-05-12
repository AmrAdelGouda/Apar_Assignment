# Apar Assignment 
# Note: I force open KSA country from the URL as the default countries list when access the website from Egypt not Include KSA,Kuwait and Bahrain that required in the assignment
Tool : selenium 
Testing Framework: TestNG 
DesignPattern : Page object model 
Java : 17 
Data References : saved into json file at Data directory, read from it by using dataprovider from testng
{
  "Tasks Data": [
{
"countryName" : "KSA",
"currency" : "SAR",
"firstPackage" : "LITE",
"secondPackage" : "CLASSIC",
"thirdPackage" : "PREMIUM",
"LitePrice" : "15",
"ClassicPrice" : "25",
"PremiumPrice" : "60"
},
{
"countryName" : "Bahrain",
"currency" : "BHD",
"firstPackage" : "LITE",
"secondPackage" : "CLASSIC",
"thirdPackage" : "PREMIUM",
"LitePrice" : "2",
"ClassicPrice" : "3",
"PremiumPrice" : "6"
},
{
"countryName" : "Kuwait",
"currency" : "KWD",
"firstPackage" : "LITE",
"secondPackage" : "CLASSIC",
"thirdPackage" : "PREMIUM",
"LitePrice" : "1.2",
"ClassicPrice" : "2.5",
"PremiumPrice" : "4.8"
}
  ]
}
covered Scenarios: 
Validate the Subscription Package type for Each Selected Country and compare it with the reference Data
Validate the Currency for Each Selected Country and compare it with the reference Data
Validate the Subscription Package Price for Each Selected Country and compare it with the reference Data
