# BabySitter
Java kata with Spock TDD

Background (from: https://gist.github.com/jameskbride/5482722)
----------
This kata simulates a babysitter working and getting paid for one night.  The rules are pretty straight forward:

The babysitter 
- starts no earlier than 5:00PM
- leaves no later than 4:00AM
- gets paid $12/hour from start-time to bedtime
- gets paid $8/hour from bedtime to midnight
- gets paid $16/hour from midnight to end of job
- gets paid for full hours (no fractional hours)

Feature:
As a babysitter
In order to get paid for 1 night of work
I want to calculate my nightly charge

Next Steps
----------
I've got the kata to a working state, but here are the next steps I would implement if I wanted to spice things up:
- New `PaymentCalculator` interface and `PaymentCalculatorImpl` class
- Move `calculateWage`, `validateHourInputs`, and `calculatePay` to new `PaymentCalculator` classes
- Have `BabySitter#main` take in console args, call `PaymentCalculator`, and handle any thrown exceptions by printing exception messages
- New custom `StartTimeException`, `BedTimeException`, `EndTimeException` classes extending `IllegalArgumentException`, create custom exception message constants that can be printed to console
- New `CalculateWageRequest` class that holds the start/bed/end times inputs, `PaymentCalculator` can take it in as an input
- Add Validator pattern to `CalculateWageRequest` and move `validateHourInputs` into the request
- Functions in `BabySitter` class to take in inputs and create a `CalculateWageRequest` from both int and time inputs
- Update `BabySitterSpec` to match the above changes

These changes would make the project a lot more sophisticated, but with the simple problem statement and quick solution required, I think the project is clean and fine as-is, so they're not necessary at the moment.
