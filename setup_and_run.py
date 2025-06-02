import os
import subprocess
import sys

FOLDER_SCRIPT = "create_contest_folder.py"

def main():
    print(f"Running {FOLDER_SCRIPT} ...\n", file=sys.stderr)
    python_executable = sys.executable
    
    process = subprocess.run(
        [python_executable, FOLDER_SCRIPT], 
        text=True, 
        check=False # Don't raise for non-zero, we'll exit with its code
    )
    
    sys.exit(process.returncode)

if __name__ == "__main__":
    main()
