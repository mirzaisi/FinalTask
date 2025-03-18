# FinalTask

This project uses:
- **Selenium WebDriver** (with WebDriver Manager)
- **Maven**
- **JUnit 4** (parameterized for UC-3)
- **Parallel Execution** (configured via Surefire)
- **Hamcrest** for assertions
- **XPath** locators
- **Singleton** pattern in `DriverFactory`

## Test Cases

### UC-1: Empty Credentials
1. Go to `https://www.saucedemo.com`
2. Leave username/password empty
3. Click Login
4. Check error: **"Username is required"**

### UC-2: Username Only
1. Go to `https://www.saucedemo.com`
2. Enter username
3. Leave password empty
4. Click Login
5. Check error: **"Password is required"**

### UC-3: Valid Credentials
1. Go to `https://www.saucedemo.com`
2. Enter valid username (`standard_user`, etc.)
3. Password: **"secret_sauce"**
4. Click Login
5. Check title: **"Swag Labs"**

## Running Tests

1. **Default (Firefox)**:
