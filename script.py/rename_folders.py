import os

def load_problem_names(file_path):
    """
    Loads the problem names from the list.txt file and returns a dictionary.
    The keys are the problem numbers, and the values are the full names.
    """
    problem_names = {}
    with open(file_path, 'r', encoding='utf-8') as file:
        for line in file:
            line = line.strip()
            if line:
                parts = line.split('_')
                category = parts[0]
                number = parts[1]
                name = '_'.join(parts)
                problem_names[number] = name
    return problem_names

def rename_folders(root_dir, problem_names):
    """
    Renames folders in the BOJ and SWEA directories if their names match
    a problem number in the problem_names dictionary.
    """
    for dirpath, dirnames, filenames in os.walk(root_dir):
        # Check if current directory is BOJ or SWEA
        if os.path.basename(dirpath) in ['BOJ', 'SWEA']:
            for dirname in dirnames:
                # Check if the directory name is a 4 or 5 digit number
                if dirname.isdigit() and len(dirname) in [4, 5]:
                    problem_number = dirname
                    if problem_number in problem_names:
                        new_dirname = problem_names[problem_number]
                        old_path = os.path.join(dirpath, dirname)
                        new_path = os.path.join(dirpath, new_dirname)
                        os.rename(old_path, new_path)
                        print(f'Renamed: {old_path} -> {new_path}')

if __name__ == "__main__":
    root_directory = r"C:\Users\SSAFY\Documents\GitHub\AlgorithmStudy"
    list_file_path = os.path.join(root_directory, "list.txt")
    
    # Load problem names from the text file
    problem_names_dict = load_problem_names(list_file_path)
    
    # Rename folders according to the problem names
    rename_folders(root_directory, problem_names_dict)
