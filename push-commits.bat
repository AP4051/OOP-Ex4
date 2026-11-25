@echo off
setlocal
cd /d "%~dp0"
echo Checking Git repository...
git rev-parse --is-inside-work-tree >nul 2>&1
if errorlevel 1 (
  echo ERROR: This folder is not a Git repository.
  pause
  exit /b 1
)
for /f "delims=" %%B in ('git branch --show-current') do set CURRENT_BRANCH=%%B
if not "%CURRENT_BRANCH%"=="assignment-solutions" (
  echo ERROR: Expected branch assignment-solutions, found %CURRENT_BRANCH%.
  echo Run: git switch assignment-solutions
  pause
  exit /b 1
)
git diff --quiet
if errorlevel 1 (
  echo ERROR: You have uncommitted changes. Review them before pushing.
  pause
  exit /b 1
)
git diff --cached --quiet
if errorlevel 1 (
  echo ERROR: You have staged changes that are not committed.
  pause
  exit /b 1
)
echo Pushing the separate class and Main commits to GitHub...
git push -u origin assignment-solutions
if errorlevel 1 (
  echo Push failed. Check your internet connection and GitHub authentication.
  pause
  exit /b 1
)
echo Push completed successfully.
echo Next, create a Pull Request from assignment-solutions.
pause
