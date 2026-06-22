CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
)
IS
    v_balance NUMBER;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'Insufficient Funds'
        );
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Failed: '
            || SQLERRM
        );
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id NUMBER,
    p_percent NUMBER
)
IS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent/100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(
            'Employee does not exist.'
        );
END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerid NUMBER,
    p_name VARCHAR2,
    p_dob DATE,
    p_balance NUMBER
)
IS
BEGIN

    INSERT INTO Customers(
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified
    )
    VALUES(
        p_customerid,
        p_name,
        p_dob,
        p_balance,
        SYSDATE
    );

    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE(
            'Customer ID already exists.'
        );
END;
/

--Testing:

SELECT AccountID, Balance
FROM Accounts;

BEGIN
    SafeTransferFunds(1, 2, 500);
END;
/

SELECT AccountID, Balance
FROM Accounts;

BEGIN
    SafeTransferFunds(1, 2, 5000);
END;
/

