CREATE TABLE Passenger (
    PassengerID INT PRIMARY KEY,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    CheckInLocationID INT NOT NULL,
    CheckInDateTime TIMESTAMP NOT NULL,
    FOREIGN KEY (CheckInLocationID) REFERENCES CheckinLocation(CheckinLocationID)
);