<section className="flex flex-col justify-center  bg-stone-50 max-md:pl-5 mt-1 rounded-lg pb-10">
    <main className="flex flex-wrap overflow-hidden gap-10 pl-8 bg-neutral-50 rounded-[50px] max-md:pl-5">
        <section className="flex flex-col my-auto h-[670px] w-1/2 text-neutral-400 max-md:max-w-full mt-5">
            <header className="flex flex-col w-full text-black max-md:max-w-full">
                <h1 className="text-5xl tracking-wide max-md:max-w-full max-md:text-4xl">
                    <span className="leading-[54px]">Get in </span>
                    <span className="text-rose-800">touch</span>
                </h1>
                <p className="w-full text-sm tracking-normal leading-6 max-md:max-w-full">
                    Enim tempor eget pharetra facilisis sed maecenas adipiscing.
                    Eu leo molestie vel, ornare non id blandit netus.
                </p>
            </header>
            <form className="flex flex-col mt-6 w-full text-base tracking-wide leading-relaxed max-md:max-w-full">
                {inputFields.map((field, index) => (
                    <div
                        key={index}
                        className="flex overflow-hidden flex-col pt-3 mt-2 max-w-full h-[55px] w-[548px]"
                    >
                        <label
                            htmlFor={field.label
                                .toLowerCase()
                                .replace(/\s+/g, '-')}
                            className="sr-only"
                        >
                            {field.label}
                        </label>
                        <input
                            type={field.type}
                            id={field.label.toLowerCase().replace(/\s+/g, '-')}
                            placeholder={field.label}
                            className="w-full bg-transparent border-b border-zinc-500 focus:outline-none focus:border-rose-800"
                            aria-label={field.label}
                        />
                    </div>
                ))}
                <div className="flex flex-wrap gap-6 items-start mt-2 whitespace-nowrap h-[46px] max-md:max-w-full">
                    {addressFields.map((field, index) => (
                        <div
                            key={index}
                            className={`flex overflow-hidden flex-col pt-3 mt-2 max-w-full h-[55px] ${field.width}`}
                        >
                            <label
                                htmlFor={field.label
                                    .toLowerCase()
                                    .replace(/\s+/g, '-')}
                                className="sr-only"
                            >
                                {field.label}
                            </label>
                            <input
                                type={field.type}
                                id={field.label
                                    .toLowerCase()
                                    .replace(/\s+/g, '-')}
                                placeholder={field.label}
                                className="w-full bg-transparent border-b border-zinc-500 focus:outline-none focus:border-rose-800"
                                aria-label={field.label}
                            />
                        </div>
                    ))}
                </div>

                <div className="flex flex-col pt-3 mt-2 w-[548px] mt-4">
                    {/* Hidden File Input */}
                    <input
                        type="file"
                        id="file-upload"
                        className="hidden"
                        aria-label="Upload File"
                        // onChange={handleFileChange}
                    />

                    <label
                        htmlFor="file-upload"
                        className="flex items-center justify-center w-full h-16  border-2 border-dashed border-zinc-500 text-center cursor-pointer "
                    >
                        Upload Additional File
                    </label>
                    <p className="text-xs">
                        Attach file. File size of your documents should not
                        exceed 10MB
                    </p>
                </div>
                <button
                    type="submit"
                    className="mt-6 bg-rose-800 text-white py-2 px-4 rounded-lg hover:bg-rose-900 focus:outline-none w-[86%]"
                >
                    Submit
                </button>
            </form>
        </section>

        <section className="flex-grow h-[680px] w-1/2  flex items-center justify-center mt-5">
            <img
                loading="lazy"
                src={map}
                alt="Map"
                className="w-full h-full "
            />
        </section>
    </main>
</section>;
