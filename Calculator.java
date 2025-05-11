import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 350); // Adjusted window position and size
        frame.setLayout(new FlowLayout());
        
        // Set background color
        frame.getContentPane().setBackground(new Color(220, 220, 255));

        // Create input fields and result field
        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);
        JTextField resultField = new JTextField(10);
        resultField.setEditable(false);

        // Create buttons and style them
        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");

        // Button styling
        JButton[] buttons = {addButton, subtractButton, multiplyButton, divideButton};
        for (JButton button : buttons) {
            button.setBackground(new Color(100, 150, 250));
            button.setForeground(new Color(0, 0, 0)); // Set text color to black
            button.setFont(new Font("Arial", Font.BOLD, 12));
            button.setPreferredSize(new Dimension(90, 40));
        }

        // Add labels and input fields to the frame
        frame.add(new JLabel("First Number:"));
        frame.add(num1Field);
        frame.add(new JLabel("Second Number:"));
        frame.add(num2Field);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);

        // Add buttons to the frame
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);

        // Action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                resultField.setText(String.valueOf(num1 + num2));
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                resultField.setText(String.valueOf(num1 - num2));
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                resultField.setText(String.valueOf(num1 * num2));
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                if (num2 != 0) {
                    resultField.setText(String.valueOf(num1 / num2));
                } else {
                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    resultField.setText("");
                }
            }
        });

        frame.setVisible(true);
    }
}





{showPopup && (
                <div className="">
                    <div className="">
                        <h2 className="text-xl font-bold mb-10 text-gray-700">
                            Add Brand
                        </h2>
                        <input
                            type="text"
                            value={brandName}
                            onChange={handleInputChange}
                            onKeyDown={(e) => setUpdateOnEnter(e)}
                            placeholder="Enter Brand Name   "
                            className="border border-gray-500 p-2 rounded-md w-[60%] mb-5 text-gray-800 bg-gray-200 outline-none"
                        />
                        <select
                            value={selectedCategory}
                            onChange={(e) =>
                                setSelectedCategory(e.target.value)
                            }
                            className="border border-gray-500 p-2 rounded-md w-[60%] mb-3 text-gray-800 bg-gray-200 outline-none"
                        >
                            <option value="">Select Category</option>
                            {categories.map((category) => (
                                <option
                                    key={category._id}
                                    value={category._id}
                                >
                                    {category.name}
                                </option>
                            ))}
                        </select>
                        {/* //IDEA: sub categories code */}
                        <div>
                            <div className="mt-3">
                                <h3 className="text-gray-700 font-semibold mb-3">
                                    Select Subcategories:
                                </h3>
                                {subCategories.map((subCategory) => (
                                    <div
                                        key={subCategory._id}
                                        className="flex items-center mb-2"
                                    >
                                        <input
                                            type="checkbox"
                                            id={`subCategory-${subCategory._id}`}
                                            checked={selectedSubCategories.includes(
                                                subCategory._id,
                                            )}
                                            onChange={(event) =>
                                                handleCheckboxChange1(
                                                    event,
                                                    subCategory._id,
                                                )
                                            }
                                            className="mr-2"
                                        />
                                        <label
                                            htmlFor={`subCategory-${subCategory.id}`}
                                            className="text-gray-800"
                                        >
                                            {subCategory.name}
                                        </label>
                                    </div>
                                ))}
                            </div>
                            <div className="mt-4">
                                <h3 className="text-gray-700 font-semibold">
                                    Selected Subcategories:
                                </h3>
                                <div className="flex flex-wrap gap-2 mt-2">
                                    {selectedSubCategories.map(
                                        (subCategoryId) => {
                                            const subCategory =
                                                subCategories.find(
                                                    (sub) =>
                                                        sub._id ===
                                                        subCategoryId,
                                                );

                                            return (
                                                <div
                                                    key={subCategoryId}
                                                    className="bg-blue-200 px-3 py-1 rounded-full flex items-center"
                                                >
                                                    {subCategory?.name}
                                                    <button
                                                        onClick={() =>
                                                            setSelectedSubCategories(
                                                                selectedSubCategories.filter(
                                                                    (id) =>
                                                                        id !==
                                                                        subCategoryId,
                                                                ),
                                                            )
                                                        }
                                                        className="ml-2 text-red-600 font-bold"
                                                    >
                                                        &times;
                                                    </button>
                                                </div>
                                            );
                                        },
                                    )}
                                </div>
                            </div>
                        </div>
                        {/* //IDEA: colors selection */}
                        <div className="grid grid-cols-2 gap-4 ">
                            <div>
                                <label className="block mt-6 text-lg font-medium text-zinc-600">
                                    Select Colours:{' '}
                                </label>
                            </div>
                            <div className="mt-5 font-custom">
                                <button
                                    onClick={(e) => togglePopup(e)}
                                    className="px-4 py-2 text-white bg-blue-900 rounded-full hover:bg-blue-700"
                                >
                                    Add Colours
                                </button>
                                <button
                                    onClick={(e) => {
                                        e.preventDefault();
                                        setClearSelectedPopUp(
                                            !clearSelectedPopUp,
                                        );
                                    }}
                                    className="px-4 py-2 ml-2 text-white bg-red-700 rounded-full hover:bg-red-800"
                                >
                                    Clear Selection
                                </button>
                            </div>

                            <div>
                                {/* Color cards and remove functionality */}
                            </div>
                        </div>
                        <div className="mb-4">
                            {selectedColors.length > 0 && (
                                <div className="flex flex-wrap gap-2">
                                    {selectedColorObjects.map((color) => (
                                        <div className="flex flex-col w-32 h-32 bg-gray-100 rounded shadow ">
                                            <div
                                                key={color.value}
                                                className="relative flex flex-row w-full h-full "
                                                style={{
                                                    backgroundColor: chroma(
                                                        color.color,
                                                    )
                                                        .alpha(1)
                                                        .css(),
                                                }}
                                            >
                                                {/* <div
                          className="w-10 h-6"
                          style={{
                            backgroundColor: chroma(color).alpha(1).css(),
                          }}
                        ></div> */}
                                                <button
                                                    className="absolute top-0 text-white cursor-pointer right-1"
                                                    onClick={(e) => {
                                                        e.preventDefault();
                                                        removeSelectedColors(
                                                            color,
                                                        );
                                                    }}
                                                >
                                                    &times;
                                                </button>
                                            </div>
                                            <div className="mt-1 text-center text-zinc-400">
                                                {color.color}
                                            </div>
                                            <div className="text-center text-zinc-400">
                                                {color.ncsCode}
                                            </div>
                                        </div>
                                    ))}
                                </div>
                            )}
                        </div>
                        <div className="flex mt-8">
                            {selectedFile &&
                                selectedFile.type.startsWith('image/') && (
                                    <img
                                        src={URL.createObjectURL(selectedFile)}
                                        alt="Preview"
                                        className="mt-2"
                                        style={{
                                            maxWidth: '150px',
                                            maxHeight: '150px',
                                        }}
                                    />
                                )}
                            <label
                                htmlFor="profile-picture"
                                className="cursor-pointer px-3 py-2 focus:outline-none mt-3 text-blue-600"
                            >
                                Upload Image
                            </label>
                            <input
                                id="profile-picture"
                                name="profile-picture"
                                type="file"
                                onChange={handleFileChange}
                                className="hidden"
                            />
                        </div>
                        <div className="h-6 flex items-center">
                            {duplicateCategory && (
                                <div className="text-red-500">
                                    Category already exists.
                                </div>
                            )}
                        </div>
                        <div className="mt-10 flex justify-end gap-4">
                            <button
                                onClick={handleClosePopup}
                                className="bg-red-500 hover:bg-red-700 text-white px-4 py-2 rounded-md"
                            >
                                Close
                            </button>
                            <button
                                onClick={handleSubmit}
                                disabled={
                                    !brandName.trim() ||
                                    !selectedCategory ||
                                    !selectedSubCategories
                                }
                                className={`px-5 py-2 rounded-md mr-2 text-white ${
                                    !brandName.trim() ||
                                    !selectedCategory ||
                                    !selectedSubCategories
                                        ? 'bg-blue-300 cursor-not-allowed'
                                        : 'bg-blue-500 hover:bg-blue-700'
                                }`}
                            >
                                {loading ? 'Adding...' : 'Add'}
                            </button>
                        </div>
                    </div>
                </div>
            )}