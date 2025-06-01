import os
from datetime import datetime
import pytz

def ordinal(n):
    if 10 <= n % 100 <= 20:
        suffix = 'th'
    else:
        suffix = {1: 'st', 2: 'nd', 3: 'rd'}.get(n % 10, 'th')
    return f"{n}{suffix}"

def print_header(text):
    print("\n" + "=" * 40)
    print(text)
    print("=" * 40 + "\n")

def platform_fullname(shortcut, folder_type):
    shortcut = shortcut.lower()
    if shortcut in ['l', 'leetcode']:
        return 'LC_Daily' if folder_type == 'daily' else 'LC_Contest'
    if shortcut in ['c', 'codeforces']:
        return 'CF_Daily' if folder_type == 'daily' else 'CF_Contest'
    if shortcut in ['g', 'gfg']:
        return 'GFG_Daily' if folder_type == 'daily' else 'GFG_Contest'
    return shortcut

def folder_type_fullname(shortcut):
    shortcut = shortcut.lower()
    if shortcut in ['d', 'daily']:
        return 'daily'
    if shortcut in ['c', 'contest']:
        return 'contest'
    return shortcut

def create_files_in_folder(folder, is_daily, num_questions=0):
    try:
        if is_daily:
            os.makedirs(folder, exist_ok=True)
            filenames = ["readme.md", "solution.md", "solution.java"]
            for fname in filenames:
                file_path = os.path.join(folder, fname)
                with open(file_path, "w") as f:
                    if fname == "readme.md":
                        f.write(f"# Daily Problem {os.path.basename(folder)}\n")
                    elif fname == "solution.md":
                        f.write(f"# Solution for {os.path.basename(folder)}\n")
                print(f"  Created file: {file_path}")
        else:
            os.makedirs(folder, exist_ok=True)
            for i in range(1, num_questions + 1):
                q_folder = os.path.join(folder, f"q{i}")
                os.makedirs(q_folder, exist_ok=True)
                print(f"  Created: {q_folder}")
                filenames = ["readme.md", "solution.md", "solution.java"]
                for fname in filenames:
                    file_path = os.path.join(q_folder, fname)
                    with open(file_path, "w") as f:
                        if fname == "readme.md":
                            f.write(f"# Problem q{i}\n")
                        elif fname == "solution.md":
                            f.write(f"# Solution for q{i}\n")
                    print(f"    Created file: {file_path}")
        return True
    except Exception as e:
        print(f"Error creating files: {e}")
        return False

def main():
    print_header("Competitive Programming Folder Creator")
    folder_type_input = input("Type of folder? (daily/contest or d/c): ").strip().lower()
    folder_type = folder_type_fullname(folder_type_input)
    if folder_type not in ['daily', 'contest']:
        print("Invalid folder type. Use 'daily' (or 'd') or 'contest' (or 'c').")
        return

    platform_input = input("Platform (l/c/g or leetcode/codeforces/gfg): ").strip().lower()
    platform = platform_fullname(platform_input, folder_type)

    if folder_type == "daily":
        # Fully automate: get today's date in Asia/Kolkata
        tz = pytz.timezone('Asia/Kolkata')
        now = datetime.now(tz)
        date = now.day
        month = now.strftime('%B')
        folder_name = f"{ordinal(date)}{month}25"
        month_folder = os.path.join(platform, month)
        full_folder_path = os.path.join(month_folder, folder_name)
        print(f"\nToday is {folder_name}.")
        print(f"This is the folder that will be created: {full_folder_path}")
        ok = input("Is this OK? (y/n): ").strip().lower()
        if ok != "y":
            print("Aborted.")
            return
        created = create_files_in_folder(full_folder_path, is_daily=True)
    elif folder_type == "contest":
        if platform == "LC_Contest":
            wb = input("Weekly or Biweekly? (w/b): ").strip().lower()
            contest_type = "Weekly" if wb == "w" else "Biweekly"
            contest_number = input("Contest number: ").strip()
            num_questions = int(input("How many questions?: ").strip())
            folder_name = f"{contest_type}{contest_number}"
            print(f"\nThis is the folder that will be created: {platform}/{folder_name}")
            ok = input("Is this OK? (y/n): ").strip().lower()
            if ok != "y":
                print("Aborted.")
                return
            base_folder = os.path.join(platform, folder_name)
            created = create_files_in_folder(base_folder, is_daily=False, num_questions=num_questions)
        elif platform == "CF_Contest":
            contest_number = input("Contest Number: ").strip()
            div_number = input("Div Number : ").strip()
            num_questions = int(input("How many questions?: ").strip())
            folder_name = f"{contest_number}_Div{div_number}"
            print(f"\nThis is the folder that will be created: {platform}/{folder_name}")
            ok = input("Is this OK? (y/n): ").strip().lower()
            if ok != "y":
                print("Aborted.")
                return
            base_folder = os.path.join(platform, folder_name)
            created = create_files_in_folder(base_folder, is_daily=False, num_questions=num_questions)
        else:
            folder_name = input("Contest folder name (e.g., 206): ").strip()
            num_questions = int(input("Number of questions in contest: ").strip())
            print(f"\nThis is the folder that will be created: {platform}/{folder_name}")
            ok = input("Is this OK? (y/n): ").strip().lower()
            if ok != "y":
                print("Aborted.")
                return
            base_folder = os.path.join(platform, folder_name)
            created = create_files_in_folder(base_folder, is_daily=False, num_questions=num_questions)
    else:
        print("Invalid folder type. Use 'daily' or 'contest'.")
        return

    if created:
        print_header("Folders and files created successfully!")
    else:
        print_header("There was an error creating folders/files.")

if __name__ == "__main__":
    main()