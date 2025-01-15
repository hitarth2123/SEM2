import time

# Timer decorator
def timer(func):
    def wrapper(*args, **kwargs):
        start_time = time.time()
        result = func(*args, **kwargs)
        end_time = time.time()
        print(f"Execution time: {end_time - start_time:.5f} seconds")
        return result
    return wrapper

@timer
def example_function():
    time.sleep(1)
    print("Function executed")

# Example usage
example_function()
