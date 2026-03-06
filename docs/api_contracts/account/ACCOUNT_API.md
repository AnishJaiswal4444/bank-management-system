# 📄 API Contract: Account Module

## Unified Creation Endpoint
## Owner: Backend Team

---

# 📖 Overview

This document defines the REST API contract for the Account module.

Supported features:

- Create Account (Savings / Current)
- Get Account Details
- Get All User Accounts
- Deposit
- Withdraw
- Transfer
- Freeze Account
- Close Account

All APIs return responses wrapped in the standard `ApiResponse` structure.

---

# 📦 Standard Response Structure

```json
{
  "success": boolean,
  "message": "string",
  "data": object | array | null,
  "timestamp": "ISO-8601 datetime"
}
```

---

# 🏛 Global Business Rules

1. JWT token must be valid.
2. User must exist.
3. Branch must exist.
4. User KYC must be VERIFIED.
5. Initial deposit must be ≥ minimumRequiredBalance.
6. Multiple accounts per type are allowed.
7. Frozen accounts cannot perform transactions.
8. Closed accounts cannot perform transactions.
9. Account number format: `{BRANCHCODE}{6-digit-sequence}`
10. All monetary values use BigDecimal.

---

# 1️⃣ Create Account (Unified)

## Endpoint Details

**Method:** POST  
**URL:** `/api/accounts`  
**Content-Type:** `application/json`  
**Authentication:** Required (JWT Bearer Token)

---

## 🔐 Request

### Headers

```
Authorization: Bearer <JWT_TOKEN>
```

### Request Body (Savings Example)

```json
{
    "accountType": "SAVINGS",
    "userId": 1,
    "branchId": 2,
    "initialDeposit": 5000.00,
    "savingDetails": {
        "interestRate": 4.50,
        "withdrawalLimit": 25000.00,
        "dailyTxnLimit": 50000.00,
        "maxWithdrawals": 5
    }
}
```

### Request Body (Current Example)

```json
{
  "accountType": "CURRENT",
  "userId": 1,
  "branchId": 2,
  "initialDeposit": 10000,
  "currentDetails": {
    "overdraftLimit": 50000,
    "overdraftInterestRate": 8.5,
    "monthlyServiceFee": 500,
    "freeTransLimit": 10,
    "gstNumber": "GST1234567"
  }
}
```

---

## ✅ Success Response (HTTP 201 Created)

### Savings Response

```json
{
  "success": true,
  "message": "Account created successfully",
  "data": {
    "accountId": 101,
    "accountNumber": "ACC000101",
    "accountType": "SAVINGS",
    "accountBalance": 5000.00,
    "minimumRequiredBalance": 1000.00,
    "accountStatus": "ACTIVE",
    "savingDetails": {
      "interestRate": 4.50,
      "withdrawalLimit": 25000.00,
      "dailyTxnLimit": 50000.00,
      "maxWithdrawals": 5
    },
    "createdAt": "2026-03-06T20:30:00"
  },
  "timestamp": "2026-03-06T20:30:00"
}
```

### Current Response

```json
{
    "success": true,
    "message": "Account created successfully",
    "data": {
        "accountId": 22,
        "accountNumber": "ACC000006",
        "accountType": "CURRENT",
        "accountBalance": 10000,
        "minimumRequiredBalance": 1000,
        "accountStatus": "ACTIVE",
        "currentDetails": {
            "overdraftLimit": 50000,
            "overdraftInterestRate": 8.5,
            "overdraftUsed": 0,
            "monthlyServiceFee": 500,
            "freeTransLimit": 10,
            "gstNumber": "GST1234567"
        },
        "createdAt": "2026-03-06T22:58:57"
    },
    "timestamp": "2026-03-06T22:58:57"
}

---

# 2️⃣ Get Account By Account Number

**Method:** GET  
**URL:** `/api/accounts/{accountNumber}`  
**Authentication:** Required  

---

# 3️⃣ Get All Accounts By User

**Method:** GET  
**URL:** `/api/accounts/user/{userId}`  

---

# 4️⃣ Deposit

**Method:** POST  
**URL:** `/api/accounts/{accountNumber}/deposit`  

Request:

```json
{
  "amount": 2000.00
}
```

---

# 5️⃣ Withdraw

**Method:** POST  
**URL:** `/api/accounts/{accountNumber}/withdraw`  

Request:

```json
{
  "amount": 1500.00
}
```

---

# 6️⃣ Transfer

**Method:** POST  
**URL:** `/api/accounts/transfer`  

Request:

```json
{
  "fromAccount": "BR002000123",
  "toAccount": "BR002000124",
  "amount": 1500.00
}
```

---

# 7️⃣ Freeze Account

**Method:** PUT  
**URL:** `/api/accounts/{accountNumber}/freeze`  

---

# 8️⃣ Close Account

**Method:** PUT  
**URL:** `/api/accounts/{accountNumber}/close`  

---

# 📊 HTTP Status Codes

| Status Code | Meaning |
|------------|----------|
| 200 | OK |
| 201 | Created |
| 400 | Bad Request |
| 401 | Unauthorized |
| 404 | Not Found |
| 409 | Conflict |
| 500 | Internal Server Error |

---

# 🗄 Database Impact

- Account creation inserts into:
  - `accounts`
  - `savings_accounts` OR `current_accounts`
- Deposit / Withdraw / Transfer update balances.
- Freeze / Close update account status.
- All write operations must use `@Transactional`.
