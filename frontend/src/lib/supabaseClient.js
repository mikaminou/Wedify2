// frontend/lib/supabaseClient.js
import { createClient } from "@supabase/supabase-js";

const url = import.meta.env.VITE_SUPABASE_URL;
const anonKey = import.meta.env.VITE_SUPABASE_ANON_KEY;

//console.log("Loaded Supabase URL:", supabaseUrl);
//console.log("Loaded Supabase Key:", supabaseAnonKey ? "KEY LOADED" : "NO KEY");


if (!url || !anonKey) {
  throw new Error("Missing SUPABASE environment variables. Check .env");
}

export const supabase = createClient(url, anonKey);
