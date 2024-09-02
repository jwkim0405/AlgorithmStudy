import os

# File paths
readme_path = r"C:\Users\SSAFY\Documents\GitHub\AlgorithmStudy\README.md"
list_path = r"C:\Users\SSAFY\Documents\GitHub\AlgorithmStudy\list.md"

# Read the list.md file and store the links in a dictionary
link_dict = {}
with open(list_path, 'r', encoding='utf-8') as list_file:
    for line in list_file:
        if line.startswith("["):
            # Extract the problem name and link
            start_idx = line.index("[") + 1
            end_idx = line.index("]")
            problem_name = line[start_idx:end_idx]

            start_link_idx = line.index("(") + 1
            end_link_idx = line.index(")")
            link = line[start_link_idx:end_link_idx]

            link_dict[problem_name] = link

# Read the README.md file and update it with links from the dictionary
updated_lines = []
with open(readme_path, 'r', encoding='utf-8') as readme_file:
    for line in readme_file:
        updated_line = line
        for problem_name, link in link_dict.items():
            if problem_name in line:
                # Replace the problem name with a markdown link
                updated_line = line.replace(problem_name, f"[{problem_name}]({link})")
        updated_lines.append(updated_line)

# Write the updated content back to the README.md file
with open(readme_path, 'w', encoding='utf-8') as readme_file:
    readme_file.writelines(updated_lines)

print("README.md has been updated with links.")
