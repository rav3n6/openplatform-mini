
export async function getAllUsers() {

    const response = await fetch('/api/assoc/getAll');
    return await response.json();
}
